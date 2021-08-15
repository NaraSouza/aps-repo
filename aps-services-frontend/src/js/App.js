import React, { useState } from "react";
import { HashRouter as Router, Route, Switch } from "react-router-dom";

import logo from "../assets/logo.png";
import "../css/App.scss";
import ChangePassword from "./access/ChangePassword";
import Login from "./access/Login";
import SignUp from "./access/SignUp";
import MyAccount from "./access/MyAccount";
import CancelOrder from "./order/CancelOrder";
import MyOrders from "./order/MyOrders";
import MakeOrder from "./order/MakeOrder";
import PaymentMethods from "./order/PaymentMethods";
import Order from "./order/Order";
import RateOrder from "./order/RateOrder";

const AppContext = React.createContext();

function App() {
  const [username, setUsername] = useState("");

  const state = { username, setUsername };

  return (
    <div className="App">
      <header>
        <img src={logo} className="logo" alt="logo" />
      </header>

      <div className="content">
        <AppContext.Provider value={state}>
          <Router>
            <Switch>
              <Route exact path="/" component={Login} />

              <Route path="/signUp" component={SignUp} />

              <Route path="/changePassword" component={ChangePassword} />

              <Route path="/myAccount" component={MyAccount} />

              <Route path="/myOrders" component={MyOrders} />

              <Route path="/makeOrder" component={MakeOrder} />

              <Route path="/paymentMethods" component={PaymentMethods} />

              <Route path="/cancelOrder/:orderData" component={CancelOrder} />

              <Route path="/rateOrder/:orderData" component={RateOrder} />

              <Route path="/order/:orderData" component={Order} />
            </Switch>
          </Router>
        </AppContext.Provider>
      </div>
    </div>
  );
}

export { AppContext };
export default App;
