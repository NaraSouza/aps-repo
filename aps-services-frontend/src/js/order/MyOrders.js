import OrderSummary from "./OrderSummary";

const username = localStorage.getItem("username");

export default function MyOrders() {
  const pendingOrders = [
    {
      restaurante: "Galo Padeiro",
      _id: 1,
      avaliacao: {},
      itens: [
        {
          name: "Sanduiche brie e parma",
          description: "Croissant",
          price: 22,
        },
        {
          name: "Madeleine tradicional",
          description: "",
          price: 7,
        },
      ],
      status: "em andamento",
      total: 29,
      usuario: username,
    },
  ];

  const completedOrders = [
    {
      status: "concluido",
      itens: [
          "pizza",
          "garrafa"
      ],
      avaliacao: {},
      usuario: "r",
      restaurante: "Degusta"
    },
    {
      restaurante: "Galo Padeiro",
      _id: 3,
      avaliacao: {},
      itens: [
        {
          name: "Sanduiche charque e aioli",
          description: "Croissant",
          price: 25,
        },
      ],
      status: "concluido",
      total: 25,
      usuario: username,
    },
  ];

  return (
    <div className="my-orders-screen">
      <span className="title">Meus pedidos</span>

      <div className="mt-4" style={{ height: "40%" }}>
        <span className="subtitle">Em aberto</span>

        <div className="orders">
          {pendingOrders.map((order, index) => (
            <OrderSummary key={index} order={order} />
          ))}
        </div>
      </div>

      <div style={{ height: "50%" }}>
        <span className="subtitle">Histórico</span>

        <div className="orders">
          {completedOrders.map((order, index) => (
            <OrderSummary key={index} order={order} />
          ))}
        </div>
      </div>
    </div>
  );
}
