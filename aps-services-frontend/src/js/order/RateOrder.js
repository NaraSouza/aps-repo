import { Formik } from "formik";

export default function RateOrder() {
  return (
    <Formik
      initialValues={{ nota: "", comentario: "" }}
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
          <div className="rate-order-screen">
            <span className="title">Dê uma nota:</span>

            <input
              name="nota"
              placeholder="Escreva sua nota de 0 à 5"
              onChange={handleChange}
              value={values.nota}
              type="number"
            />

            <textarea
              name="comentario"
              className="mb-4"
              placeholder="Deixe um comentário"
              onChange={handleChange}
              value={values.comentario}
            />

            <div className="buttons">
              <button className="btn secondary">Cancelar</button>

              <button className="btn primary" type="submit">
                Avaliar pedido
              </button>
            </div>
          </div>
        </form>
      )}
    </Formik>
  );
}
