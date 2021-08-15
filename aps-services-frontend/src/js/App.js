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

function App() {
  return (
    <div className="App">
      <header>
        <img src={logo} className="logo" alt="logo" />
      </header>

      <div className="content">
        <Router>
          <Switch>
            <Route exact path="/" component={Login} />

            <Route path="/signUp" component={SignUp} />

            <Route path="/changePassword" component={ChangePassword} />

            <Route path="/myAccount" component={MyAccount} />

            <Route path="/myOrders" component={MyOrders} />

            <Route path="/makeOrder" component={MakeOrder} />

            <Route path="/paymentMethods" component={PaymentMethods} />

            <Route path="/cancelOrder" component={CancelOrder} />

            <Route path="/rateOrder" component={RateOrder} />

            <Route path="/order" component={Order} />
          </Switch>
        </Router>
      </div>
    </div>
  );
}

export default App;
