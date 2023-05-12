const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const port = 3010;
const path = require('path');

app.use(express.static('static'));
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

const values = [];

app.get('/', (req, res) => {
  res.send('Olá Mundo!');
});

app.get('/form', (req, res) => {
  res.sendFile(path.resolve('pages/form.html'));
});

app.get('/vetor', (req, res) => {
  res.json(values);
});

app.post('/vetor', (req, res) => {
  values.push(req.body.value);
  res.send('Valor cadastrado.');
});

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`);
});
