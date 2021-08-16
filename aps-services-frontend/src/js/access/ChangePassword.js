import axios from "axios";
import { Formik } from "formik";
import { useState } from "react";

export default function ChangePassword() {
  const username = localStorage.getItem("username");
  const [data, setData] = useState({});

  axios
    .get(`https://localhost:5555/api/people/${username}`)
    .then((response) => {
      setData({
        nome: response.name,
        email: response.email,
        senha: response.password,
        rua: response.endereco.rua,
        numero: response.endereco.numero,
        complemento: response.endereco.complemento,
        bairro: response.endereco.bairro,
        cidade: response.endereco.cidade,
        estado: response.endereco.estado,
        cep: response.endereco.cep,
      });
    })
    .catch(() => alert("Erro ao buscar dados"));

  return (
    <Formik
      initialValues={{ email: "", newPassword: "", confirmNewPassword: "" }}
      onSubmit={(values, { setSubmitting }) => {
        setTimeout(() => {
          axios
            .put("https://localhost:5555/api/people/", {
              ...data,
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
