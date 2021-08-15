import { Formik } from "formik";

export default function Login() {
  return (
    <Formik
      initialValues={{ email: "", password: "" }}
      onSubmit={(values, { setSubmitting }) => {
        setTimeout(() => {
          alert(JSON.stringify(values, null, 2));
          //fazer get
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

            <a
              href="https://reactjs.org"
              target="_blank"
              rel="noopener noreferrer"
            >
              Alterar senha
            </a>

            <div className="buttons">
              <button className="btn secondary">Cadastrar</button>

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
