import OrderSummary from "./OrderSummary";

export default function MyOrders() {
  const pendingOrders = [
    {
      restaurante: "Galo Padeiro",
      itens: [
        {
          _id: 1,
          name: "Sanduiche brie e parma",
          description: "Croissant",
          price: 22,
          avaliacao: {},
        },
        {
          _id: 2,
          name: "Madeleine tradicional",
          description: "",
          price: 7,
          avaliacao: {},
        },
      ],
      status: "em andamento",
      total: 29,
    },
  ];

  const completedOrders = [
    {
      restaurant: "Degusta",
      itens: [{ name: "Sorvete Doce de Leite", description: "", price: 30 }],
      status: "concluido",
      total: 30,
    },
    {
      restaurant: "Galo Padeiro",
      itens: [
        {
          name: "Sanduiche charque e aioli",
          description: "Croissant",
          price: 25,
        },
      ],
      status: "concluido",
      total: 25,
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
