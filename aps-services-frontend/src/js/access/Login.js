import axios from "axios";
import { Formik } from "formik";
import { Link } from "react-router-dom";

export default function Login() {
  return (
    <Formik
      initialValues={{ email: "", password: "" }}
      onSubmit={(values, { setSubmitting }) => {
        setTimeout(() => {
          axios
            .post("http://localhost:5555/api/people/login", {email: values.email, senha: values.password})
            .then(() => window.open("#/myOrders", "_self"))
            .catch(() => alert("Erro ao fazer login"));

          setSubmitting(false);
        }, 400);
      }}
    >
      {({ values, handleChange, handleSubmit }) => (
        <form onSubmit={handleSubmit}>
          <div className="login-screen">
            <span className="title">Login</span>

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

            <a href="#/changePassword" target="_self" rel="noopener noreferrer">
              Alterar senha
            </a>

            <div className="buttons">
              <Link className="btn secondary" to="/signUp">
                Cadastrar
              </Link>

              <button className="btn primary" type="submit">
                Login
              </button>
            </div>
          </div>
        </form>
      )}
    </Formik>
  );
}
