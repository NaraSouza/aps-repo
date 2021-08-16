import axios from "axios";
import classnames from "classnames";
import { useContext, useState } from "react";
import { useParams } from "react-router-dom";

import { AppContext } from "../App";

export default function PaymentMethods({
  paymentMethods = [
    { name: "Visa - Débito" },
    { name: "Mastercard - Débito" },
    { name: "Elo - Débito" },
    { name: "Visa - Crédito" },
    { name: "Mastercard - Crédito" },
    { name: "Elo - Crédito" },
  ],
}) {
  const [chosenMethod, setChosenMethod] = useState("");
  const { username } = useContext(AppContext);
  const debitCards = paymentMethods.filter((paymentMethod) =>
    paymentMethod.name.includes("Débito")
  );
  const creditCards = paymentMethods.filter((paymentMethod) =>
    paymentMethod.name.includes("Crédito")
  );
  const { orderData } = useParams();

  let order = JSON.parse(orderData);

  order.usuario = username;

  return (
    <div className="payment-methods-screen">
      <span className="title">Escolha a forma de pagamento</span>

      <div>
        {debitCards.map((paymentMethod) => (
          <span
            className={classnames(
              "payment-method-card",
              paymentMethod.name === chosenMethod && "active"
            )}
            onClick={() => setChosenMethod(paymentMethod.name)}
          >
            {paymentMethod.name}
          </span>
        ))}
      </div>

      <div>
        {creditCards.map((paymentMethod) => (
          <span
            className={classnames(
              "payment-method-card",
              paymentMethod.name === chosenMethod && "active"
            )}
            onClick={() => setChosenMethod(paymentMethod.name)}
          >
            {paymentMethod.name}
          </span>
        ))}
      </div>

      <div style={{ width: "100%", display: "flex", justifyContent: "center" }}>
        <button
          className="btn primary"
          onClick={() => {
            axios
              .post("https://localhost:3001/create/", {
                pedido: order,
                pagamento: { forma: chosenMethod, valor: order.total },
              })
              .then(() => alert("Pedido criado com sucesso"))
              .catch(() => alert("Erro ao criar pedido"));
          }}
        >
          Realizar pagamento
        </button>
      </div>
    </div>
  );
}
