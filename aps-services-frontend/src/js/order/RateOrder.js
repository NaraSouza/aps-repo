import axios from "axios";
import { Formik } from "formik";
import { Link, useParams } from "react-router-dom";

export default function RateOrder() {
  const { orderData } = useParams();

  const order = JSON.parse(orderData);

  return (
    <Formik
      initialValues={{ nota: "", comentario: "" }}
      onSubmit={(values, { setSubmitting }) => {
        setTimeout(() => {
          console.log(order, values)
          axios
            .put("http://localhost:3001/evaluate/", {
              pedido: order,
              avaliacao: values,
            })
            .then(() => alert("Pedido avaliado com sucesso"))
            .catch(() => alert("Erro ao avaliar pedido"));

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
              <Link className="btn secondary" to="/myOrders">
                Cancelar
              </Link>

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
