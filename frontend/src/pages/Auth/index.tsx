import { ReactComponent as AuthImage } from 'assets/images/auth-image.svg';
import { Route, Switch } from 'react-router-dom';

import './styles.css';

const Auth = () => {
  return (
    <div className="auth-container">
      <div className="auth-banner-container">
        <h1>Rate Movies</h1>
        <p>Tell me what you think of your favorite movie</p>
        <AuthImage />
      </div>
      <div className="auth-form-container">
        <Switch>
          <Route path="/">
            <h1>Login Card</h1>
          </Route>
        </Switch>
      </div>
    </div>
  );
};

export default Auth;
