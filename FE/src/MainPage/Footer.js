import React from "react";
import "./Footer.css";
import { Link } from "react-router-dom";

function Footer() {
  return (
    <>
      <div className="bottomBar">
        <Link to="/main">
          <div className="homeBtn">
            <div className="home"></div>
            <div className="homeTitle">Home</div>
          </div>
        </Link>
        <Link to="/reservation">
          <div className="reservationBtn">
            <div className="reservation"></div>
            <div className="reservationTitle">Reservation</div>
          </div>
        </Link>
        <Link to="/community">
          <div className="communityBtn">
            <div className="community"></div>
            <div className="communityTitle">Community</div>
          </div>
        </Link>
        <Link to="/account">
          <div className="accountBtn">
            <div className="account"></div>
            <div className="accountTitle">Account</div>
          </div>
        </Link>
        <div className="bottomBarDiv"> </div>
      </div>
    </>
  );
}

export default Footer;
