import './styles.css';

const Navbar = () => {
  return (
    <nav className="navbar bg-primary main-nav">
      <a href="link" className="nav-logo-text">
        <h4>MovieFlix</h4>
      </a>

      <div className="nav-login-logout">
        <a href="link">LOG OUT</a>
      </div>
    </nav>
  );
};

export default Navbar;
