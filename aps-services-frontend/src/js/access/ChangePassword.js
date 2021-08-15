import { Formik } from "formik";

export default function ChangePassword() {
  return (
    <Formik
      initialValues={{ email: "", newPassword: "", confirmNewPassword: "" }}
      onSubmit={(values, { setSubmitting }) => {
        setTimeout(() => {
          alert(JSON.stringify(values, null, 2));
          //fazer post
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
