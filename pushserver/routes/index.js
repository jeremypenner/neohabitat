const express = require('express');


class IndexRoutes {
  constructor(habiproxy, config) {
    this.habiproxy = habiproxy;
    this.config = config;
    this.router = express.Router();
    this.setRoutes();
  }

  setRoutes() {
    var self = this;
    this.router.get('/', function(req, res, next) {
      var awakeSessions = self.habiproxy.awakeSessions();
      res.render('index', {
        title: 'Welcome to Neohabitat!',
        awakeSessions: awakeSessions,
        config: self.config,
      });
    });
  }
}


module.exports = IndexRoutes;