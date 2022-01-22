import Navbar from "components/Navbar";
import Auth from "pages/Auth";
import { BrowserRouter, Route, Switch } from "react-router-dom";


const Routes = () => {
  return (
  
    <BrowserRouter>
      <Navbar />
      <Switch>
        <Route path="/" exact>
          <Auth/>
        </Route>
      </Switch>
    </BrowserRouter>
  
  );
};

export default Routes;
