const MONGO_INFO = {
  host: '172.17.0.1',
  port: 27017,
  user: 'root',
  pass: 'example',
  db: 'people-db',
  authSource: 'admin',
  max: 100,
  min: 1,
}

module.exports = { MONGO_INFO }