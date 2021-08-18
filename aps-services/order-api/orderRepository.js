const Koa = require('koa')
const Router = require('koa-router')
const mongo = require('koa-mongo')
const bodyParser = require('koa-bodyparser')

const find = async (ctx, db, collection, itemToFind) => {
    const result = await ctx.mongo.db(db).collection(collection).find(itemToFind).toArray()
    return result
}

const insert = async (ctx, db, collection, itemInsert) => {
    const result = await ctx.mongo.db(db).collection(collection).insertOne(itemInsert)
    return result
}

const update = async (ctx, db, collection, itemUpdateInfo, itemUpdate) => {
    const result = await ctx.mongo.db(db).collection(collection).updateOne(itemUpdateInfo, itemUpdate)
    return result
}

module.exports = { find, insert, update }