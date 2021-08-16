const Koa = require('koa')
const Router = require('koa-router')
const mongo = require('koa-mongo')
const bodyParser = require('koa-bodyparser')
const koaRequest = require('koa-http-request');
const cors = require('@koa/cors');
const constants = require('./constants')

const app = new Koa()
const router = new Router()

app.use(cors())

app.use(mongo(constants.MONGO_INFO))

app.use(bodyParser())

app.use(koaRequest({
    json: true,
    timeout: 3000, 
    host: 'http://172.17.0.1:5555'
  }));

const validatePayment = (payment) => {
    return true
}

router.get('/status/:id', async (ctx, next) => {
    const id = ctx.params.id
    const result = await ctx.mongo.db('orders-db').collection('orders').find({ _id: mongo.ObjectId(id) }).toArray()
    if(result !== []){
        ctx.body = {status: result[0]}
        ctx.status = 200
    } else {
        ctx.body = {status: 'none'}
        ctx.status = 204
    }
});
  
router.post('/create', async (ctx, next) => {
    const {pedido, pagamento} = ctx.request.body
    if (validatePayment(pagamento)) {
        const result = await ctx.get(`/api/people/${pedido.usuario}`, null, {
            'User-Agent': 'koa-http-request'
        });
        pedido.endereco = result.client.endereco
        await ctx.mongo.db('orders-db').collection('orders').insertOne(pedido)
        await ctx.mongo.db('payments-db').collection('payments').insertOne(pagamento)
        ctx.body = {text: 'Criado com sucesso'}
        ctx.status = 200
    } else {
        ctx.body = {text: 'Pagamento inválido'}
        ctx.status = 401
    }
});

router.put('/cancel', async (ctx, next) => {
    const { _id } = ctx.request.body
    try {
    await ctx.mongo.db('orders-db').collection('orders').updateOne({_id: mongo.ObjectId(_id)}, { $set: {status: 'cancelado'} })
    ctx.body = {text: 'Cancelamento feito com sucesso'}
    ctx.status = 200
    } catch (error) {
        ctx.body = {text: 'Erro no processo de cancelamento'}
        ctx.status = 500
    }
})

router.put('/evaluate', async (ctx, next) => {
    const { pedido, avaliacao } = ctx.request.body
    try {
        await ctx.mongo.db('orders-db').collection('orders').updateOne({_id: mongo.ObjectId(pedido.id)}, { $set: {avaliacao: avaliacao} })
        ctx.body = { text: 'Avaliação feita com sucesso' }
        ctx.status = 200
    } catch (error) {
        ctx.body = {text: 'Erro no processo de avaliação'}
        ctx.status = 500
    }
})

app
  .use(router.routes())
  .use(router.allowedMethods())
  
app.listen(3001)