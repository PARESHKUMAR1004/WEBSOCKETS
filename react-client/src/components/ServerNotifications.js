import React, { useEffect, useState } from 'react'
import { over } from 'stompjs';
import SockJS from 'sockjs-client';

var stompClient = null;
const ServerNotifications = () => {


    const [notifications, setnotifications] = useState([]);
   // const [tab, setTab] = useState("SERVER");
    const [userData, setUserData] = useState({
        username: '',
        symbol: '',
        connected: false,
        message: ''
    });
   
    const connect = () => {
        let Sock = new SockJS('http://localhost:8080/ws');
        stompClient = over(Sock);
        console.log(stompClient)
        stompClient.connect({}, onConnected, onError);
    }

    const onConnected = () => {
        setUserData({ ...userData, "connected": true });

        stompClient.subscribe('/user/' + userData.username + '/private', onCompleteOrder);
        // stompClient.subscribe('/user/'+userData.username+'/symbol', onOrderBook);
       
    }

    const onOrderBook = (payload) => {
       var payloadData = JSON.parse(payload.body);
       console.log(payloadData);


    }




    const onCompleteOrder = (payload) => {
        //console.log(payload);
        var payloadData = JSON.parse(payload.body);
        console.log(payloadData)

        notifications.push(payloadData);
        setnotifications([...notifications]);


    }

    const onError = (err) => {
        console.log(err);

    }



     const sendSymbol = () => {
       //console.log(stompClient.unsubscribe("myID"));
      // console.log(stompClient.unsubscribe("sub-0"));
     //console.log(stompClient.unsubscribe({id:"sub-1"}))
       stompClient.subscribe(
         "/user/" + userData.symbol + "/symbol",
         onOrderBook
       );
      //  console.log("Hitted");
      //    stompClient.send(
      //      "/app/symbol",
      //      {},
      //      JSON.stringify(userData)
      //    );
       
       }
     



    const handleUsername = (event) => {
        const { value } = event.target;
        setUserData({ ...userData, "username": value });
    }
    const handleSymbol = (event) => {
      const { value } = event.target;
      setUserData({ ...userData, symbol: value });
    };


    const registerUser = () => {
        connect();
    }
    return (
      <div className="container">
        <h3>Your userId is: {userData.username}</h3>
        {userData.connected ? (
          <div>
            {
              <div>
                <ul>
                  {notifications.map((order) => (
                    <li>
                      <div className="completed-order-details">
                        <p>
                          Trade Id: {order.trade_id},Status: {order.status}
                          ,timestamp: {order.timestamp},volume: {order.volume}
                          ,symbol: {order.symbol}
                          ,price:{order.price},side:{order.side}
                        </p>
                      </div>
                    </li>
                  ))}
                </ul>

                <div className="get-orderbookfor">
                  <input
                    type="text"
                    className="input-symbol"
                    placeholder="enter the symbol"
                    value={userData.symbol}
                    onChange={handleSymbol}
                  />
                  <button
                    type="button"
                    className="send-button"
                    onClick={sendSymbol}
                  >
                    send
                  </button>

                </div>
                <h2>You are subscribed for {userData.symbol} symbol</h2>
              </div>
            }
          </div>
        ) : (
          <div className="register">
            <input
              id="user-name"
              placeholder="Enter your name"
              name="userName"
              value={userData.username}
              onChange={handleUsername}
              margin="normal"
            />
            <button type="button" onClick={registerUser}>
              connect
            </button>
          </div>
        )}
      </div>
    );
}

export default ServerNotifications