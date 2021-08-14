import { HashRouter as Router, Route, Switch } from "react-router-dom";

import logo from "../assets/logo.png";
import "../css/App.scss";
import ChangePassword from "./access/ChangePassword";
import Login from "./access/Login";
import SignUp from "./access/SignUp";
import CancelOrder from "./order/CancelOrder";
import MyOrders from "./order/MyOrders";
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

            <Route path="/register" component={SignUp} />

            <Route path="/changePassword" component={ChangePassword} />

            <Route path="/myOrders" component={MyOrders} />

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
