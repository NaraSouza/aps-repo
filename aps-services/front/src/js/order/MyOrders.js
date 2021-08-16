import OrderSummary from "./OrderSummary";
import axios from 'axios'
import { useEffect, useState } from 'react'

const username = localStorage.getItem("username");

export default function MyOrders() {
  const [pendingOrders, setPendingOrders] = useState([])
  const [completedOrders, setCompletedOrders] = useState([])

  useEffect(() => {
    axios.get(`http://localhost:3001/getbyuser/${username}`).then((response) => {
      console.log(response)
      setPendingOrders(response.data.orders)
    })
    axios.get(`http://localhost:3001/getbyusercompleted/${username}`).then((response) => {
      console.log(response)
      setCompletedOrders(response.data.orders)
    }).catch((err) => {
      console.log(err)
    })

  }, [])

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
