import axios from "axios";
import { Formik } from "formik";
import { useContext } from "react";
import { AppContext } from "../App";

export default function SignUp() {
  const { setUsername } = useContext(AppContext);

  return (
    <Formik
      initialValues={{
        name: "",
        email: "",
        password: "",
        rua: "",
        numero: "",
        complemento: "",
        bairro: "",
        cidade: "",
        estado: "",
        cep: "",
      }}
      onSubmit={(values, { setSubmitting }) => {
        setTimeout(() => {
          alert(JSON.stringify(values, null, 2));

          axios
            .post("https://localhost:5555/api/people/", values)
            .then(() => alert("Cliente cadastrado com sucesso"))
            .catch(() => alert("Erro ao cadastrar cliente"));

          setUsername(values.name);
          setSubmitting(false);
        }, 400);
      }}
    >
      {({ values, handleChange, handleSubmit }) => (
        <form onSubmit={handleSubmit}>
          <div className="signup-screen">
            <span className="title">Cadastrar</span>

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
              Cadastrar
            </button>
          </div>
        </form>
      )}
    </Formik>
  );
}
