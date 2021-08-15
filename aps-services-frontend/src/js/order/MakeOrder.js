import { Link } from "react-router-dom";

import Item from "./Item";

export default function MakeOrder({
  order = {
    restaurant: "Galo Padeiro",
    items: [
      { name: "Sanduiche brie e parma", description: "Croissant", price: 22 },
      { name: "Madeleine tradicional", description: "", price: 7 },
    ],
    total: 29,
    status: "em andamento",
  },
}) {
  return (
    <div className="make-order-screen">
      <span className="title" style={{ fontWeight: "bold" }}>
        {order.restaurant}
      </span>

      <div className="mt-4">
        {order.items.map((item) => (
          <Item item={item} />
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
          <Link className="btn primary" to="/paymentMethods">
            Escolher forma de pagamento
          </Link>
        </div>
      </div>
    </div>
  );
}
