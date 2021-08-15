import axios from "axios";
import { Formik } from "formik";
import { useContext, useState } from "react";
import { AppContext } from "../App";

export default function ChangePassword() {
  const { username } = useContext(AppContext);
  const [data, setData] = useState({});

  axios
    .get(`https://localhost:5555/api/people/${username}`)
    .then((response) => {
      setData({
        name: response.name,
        email: response.email,
        password: response.password,
        rua: response.endereco.rua,
        numero: response.endereco.numero,
        complemento: response.endereco.complemento,
        bairro: response.endereco.bairro,
        cidade: response.endereco.cidade,
        estado: response.endereco.estado,
        cep: response.endereco.cep,
      });
    });

  return (
    <Formik
      initialValues={{ email: "", newPassword: "", confirmNewPassword: "" }}
      onSubmit={(values, { setSubmitting }) => {
        setTimeout(() => {
          alert(JSON.stringify(values, null, 2));

          axios.put("https://localhost:5555/api/people/", {
            ...data,
            password: values.confirmNewPassword,
          });

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
