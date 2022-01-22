import { Link } from 'react-router-dom';
import './styles.css';

const Navbar = () => {
  return (
    <nav className="navbar bg-primary main-nav">
      <Link to="/" className="nav-logo-text">
        <h4>MovieFlix</h4>
      </Link>

      <div className="nav-login-logout">
        <a href="link">LOG OUT</a>
      </div>
    </nav>
  );
};

export default Navbar;
