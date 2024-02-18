import './index.css';
import './style.css';
import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import reportWebVitals from './reportWebVitals';

ReactDOM.render(
    <React.StrictMode>
        <App />
    </React.StrictMode>,
    document.getElementById('root')
);

// Pokud nepotřebujete sledovat web vitals, následující kód můžete odstranit
reportWebVitals();
