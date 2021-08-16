import axios from "axios";
import { Formik } from "formik";
import { useState, useEffect } from "react";

export default function MyAccount() {
  const [data, setData] = useState({});
  const username = localStorage.getItem("username");

  useEffect(() => {
    axios
    .get(`http://localhost:5555/api/people/${username}`)
    .then(({data}) => {  
      const { client } = data
      setData({
        nome: client.nome,
        email: client.email,
        senha: client.senha,
        rua: client.endereco.rua,
        numero: client.endereco.numero,
        complemento: client.endereco.complemento,
        bairro: client.endereco.bairro,
        cidade: client.endereco.cidade,
        estado: client.endereco.estado,
        cep: client.endereco.cep,
      });
    })
    .catch((err) => console.log(err));
  }, [])

  useEffect(() => {
    console.log(data)
  }, [data])

  if(data.nome) {
    return (
      <Formik
        initialValues={{
          nome: data.nome,
          email: data.email,
          senha: data.senha,
          rua: data.rua,
          numero: data.numero,
          complemento: data.complemento,
          bairro: data.bairro,
          cidade: data.cidade,
          estado: data.estado,
          cep: data.cep,
        }}
        onSubmit={(values, { setSubmitting }) => {
          setTimeout(() => {
            const { nome, email, senha, ...endereco } = values;
            axios
              .put("http://localhost:5555/api/people/", {nome, email, senha, endereco})
              .then(() => alert("Dados atualizados com sucesso"))
              .catch(() => alert("Erro ao atualizar dados"));

            setSubmitting(false);
          }, 400);
        }}
      >
        {({ values, handleChange, handleSubmit }) => (
          <form onSubmit={handleSubmit}>
            <div className="my-account-screen">
              <span className="title">Meus dados</span>

              <input
                name="nome"
                placeholder="Nome"
                onChange={handleChange}
                value={values.nome}
                type="text"
              />

              <input
                name="email"
                placeholder="E-mail"
                onChange={handleChange}
                value={values.email}
                type="email"
              />

              <input
                name="senha"
                placeholder="Senha"
                onChange={handleChange}
                value={values.senha}
                type="password"
              />

              <a href="#/changePassword" target="_self" rel="noopener noreferrer">
                Alterar senha
              </a>

              <span className="subtitle mt-2">Endereço</span>

              <input
                name="rua"
                placeholder="Rua"
                onChange={handleChange}
                value={values.rua}
                type="text"
              />

              <div className="input-groups">
                <input
                  name="numero"
                  placeholder="Número"
                  onChange={handleChange}
                  value={values.numero}
                  type="text"
                  style={{ width: "45%" }}
                />

                <input
                  name="bairro"
                  placeholder="Bairro"
                  onChange={handleChange}
                  value={values.bairro}
                  type="text"
                  style={{ width: "50%" }}
                />
              </div>

              <input
                name="complemento"
                placeholder="Complemento"
                onChange={handleChange}
                value={values.complemento}
                type="text"
              />

              <input
                name="cidade"
                placeholder="Cidade"
                onChange={handleChange}
                value={values.cidade}
                type="text"
              />

              <div className="input-groups">
                <input
                  name="estado"
                  placeholder="Estado"
                  onChange={handleChange}
                  value={values.estado}
                  type="text"
                  style={{ width: "55%" }}
                />

                <input
                  name="cep"
                  placeholder="CEP"
                  onChange={handleChange}
                  value={values.cep}
                  type="text"
                  style={{ width: "40%" }}
                />
              </div>

              <button className="btn primary" type="submit">
                Atualizar dados
              </button>
            </div>
          </form>
        )}
      </Formik>
    );
  }
  return <></>
}
