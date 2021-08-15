import axios from "axios";
import { Formik } from "formik";
import { useContext, useState } from "react";

import { AppContext } from "../App";

export default function MyAccount() {
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
      initialValues={{
        name: data.name,
        email: data.email,
        password: data.password,
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
          alert(JSON.stringify(values, null, 2));

          axios.put("https://localhost:5555/api/people/", values);

          setSubmitting(false);
        }, 400);
      }}
    >
      {({ values, handleChange, handleSubmit }) => (
        <form onSubmit={handleSubmit}>
          <div className="my-account-screen">
            <span className="title">Meus dados</span>

            <input
              name="name"
              placeholder="Nome"
              onChange={handleChange}
              value={values.name}
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
              name="password"
              placeholder="Senha"
              onChange={handleChange}
              value={values.password}
              type="password"
            />

            <a
              href="https://reactjs.org"
              target="_blank"
              rel="noopener noreferrer"
            >
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
