import { useParams } from "react-router-dom";

import Item from "./Item";

export default function Order({
  orderA = {
    restaurant: "Galo Padeiro",
    items: [
      { name: "Sanduiche brie e parma", description: "Croissant", price: 22 },
      { name: "Madeleine tradicional", description: "", price: 7 },
    ],
    total: 29,
    status: "em andamento",
  },
}) {
  const { orderData } = useParams();

  const orderP = JSON.parse(orderData);

  const order = orderP || orderA;

  return (
    <div className="order-screen">
      <span className="title" style={{ fontWeight: "bold" }}>
        {order.restaurant}
      </span>

      <div className="mt-4">
        {order.items.map((item, index) => (
          <Item key={index} item={item} />
        ))}
      </div>

      <div>
        <div style={{ display: "flex", justifyContent: "space-between" }}>
          <span style={{ fontWeight: "bold" }}>Total:</span>

          <span style={{ fontWeight: "bold" }}>R${order.total}</span>
        </div>

        <div className="dropdown-divider mt-4" />

        <div className="mt-4" style={{ display: "inline-grid" }}>
          <span style={{ color: "#6e6e6e" }}>Status do pedido:</span>

          <span style={{ fontSize: "22px" }}>{order.status}</span>
        </div>
      </div>
    </div>
  );
}
