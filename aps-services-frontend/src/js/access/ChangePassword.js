import axios from "axios";
import { Formik } from "formik";
import { useState, useEffect } from "react";

export default function ChangePassword() {
  const username = localStorage.getItem("username");
  const [data, setData] = useState({});


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
    .catch(() => alert("Erro ao buscar dados"));
  }, [])
  

  return (
    <Formik
      initialValues={{ email: "", newPassword: "", confirmNewPassword: "" }}
      onSubmit={(values, { setSubmitting }) => {
        setTimeout(() => {
          const { nome, email, senha, ...endereco } = data;
          axios
            .put("http://localhost:5555/api/people/", {
              nome,
              email,
              endereco,
              senha: values.confirmNewPassword,
            })
            .then(() => alert("Senha alterada com sucesso"))
            .catch(() => alert("Erro ao alterar senha"));

          setSubmitting(false);
        }, 400);
      }}
    >
      {({ values, handleChange, handleSubmit }) => (
        <form onSubmit={handleSubmit}>
          <div className="change-password-screen">
            <span className="title">Preencha os dados abaixo</span>
            <input
              name="email"
              placeholder="E-mail"
              onChange={handleChange}
              value={values.email}
              type="email"
            />

            <input
              name="newPassword"
              placeholder="Nova senha"
              onChange={handleChange}
              value={values.newPassword}
              type="password"
            />

            <input
              name="confirmNewPassword"
              placeholder="Confirmar nova senha"
              onChange={handleChange}
              value={values.confirmNewPassword}
              type="password"
            />

            <button className="btn primary" type="submit">
              Alterar senha
            </button>
          </div>
        </form>
      )}
    </Formik>
  );
}
