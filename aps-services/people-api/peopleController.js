const Koa = require('koa')
const Router = require('koa-router')
const mongo = require('koa-mongo')
const bodyParser = require('koa-bodyparser')
const constants = require('./constants')
const cors = require('@koa/cors');

const app = new Koa()
const router = new Router()

app.use(cors())

app.use(mongo(constants.MONGO_INFO))

app.use(bodyParser())
  
router.post('/api/people', async (ctx, next) => {
    const client = ctx.request.body
    try {
        await ctx.mongo.db('people-db').collection('people').insertOne(client)
        ctx.body = { text: 'Conta criada com sucesso' }
        ctx.status = 200
    }catch (error) {
        ctx.body = { text: 'Erro na criação da conta' }
        ctx.status = 500
    }
});

router.post('/api/people/login', async (ctx, next) => {
    const {email, password} = ctx.request.body
    try {
        const result = await ctx.mongo.db('people-db').collection('people').find({ email: email, senha: password }).toArray()
        if (result !== []){
            ctx.body = { text: 'Login efetuado com sucesso' }
            ctx.status = 200
        } else{
            ctx.body = { text: 'Email ou senha inválidos' }
            ctx.status = 401
        }
    }catch (error) {
        ctx.body = { text: 'Erro no login, tente novamente' }
        ctx.status = 500
    }
});

router.put('/api/people', async (ctx, next) => {
    const client = ctx.request.body
    console.log(client.nome)
    try {
        await ctx.mongo.db('people-db').collection('people').updateOne({nome: client.nome}, { $set: { nome: client.nome, senha: client.senha, endereco: client.endereco, email: client.email } })
        ctx.body = {text: 'Atualização feita com sucesso'}
        ctx.status = 200
    } catch (error) {
        console.log(error)
        ctx.body = {text: 'Erro na atualização'}
        ctx.status = 500
    }
})

router.get('/api/people/:username', async (ctx, next) => {
    const { username } = ctx.params
    try {
        const result = await ctx.mongo.db('people-db').collection('people').find({ nome: username }).toArray()
        ctx.body = {client: result[0]}
        ctx.status = 200
    } catch(error){
        ctx.body = {client: []}
        ctx.status = 404
    }
})

app
  .use(router.routes())
  .use(router.allowedMethods())
  
app.listen(5555)