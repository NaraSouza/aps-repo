const MONGO_INFO = {
  host: 'localhost',
  port: 27017,
  user: 'root',
  pass: 'example',
  db: 'people-db',
  authSource: 'admin',
  max: 100,
  min: 1,
}

module.exports = { MONGO_INFO }