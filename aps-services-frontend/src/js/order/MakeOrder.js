import { Link } from "react-router-dom";

import Item from "./Item";

const username = localStorage.getItem("username");

export default function MakeOrder({
  order = {
    restaurante: "Galo Padeiro",
    _id: 8,
    avaliacao: {},
    itens: [
      { name: "Sanduiche brie e parma", description: "Croissant", price: 22 },
      { name: "Madeleine tradicional", description: "", price: 7 },
    ],
    total: 29,
    status: "em andamento",
    usuario: username,
  },
}) {
  return (
    <div className="make-order-screen">
      <span className="title" style={{ fontWeight: "bold" }}>
        {order.restaurante}
      </span>

      <div className="mt-4">
        {order.itens.map((item, index) => (
          <Item key={index} item={item} />
        ))}
      </div>

      <div>
        <div style={{ display: "flex", justifyContent: "space-between" }}>
          <span style={{ fontWeight: "bold" }}>Total:</span>

          <span style={{ fontWeight: "bold" }}>R${order.total}</span>
        </div>

        <div className="dropdown-divider mt-4" />

        <div
          style={{ width: "100%", display: "flex", justifyContent: "center" }}
        >
          <Link
            className="btn primary"
            to={`/paymentMethods/${JSON.stringify(order)}`}
          >
            Escolher forma de pagamento
          </Link>
        </div>
      </div>
    </div>
  );
}
