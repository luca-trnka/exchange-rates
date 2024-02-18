import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ExchangeRatesList from './ExchangeRatesList';
import ExchangeRateDetail from './ExchangeRateDetail';

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/detail/:shortName" element={<ExchangeRateDetail />} />
                <Route path="/" element={<ExchangeRatesList />} />
            </Routes>
        </Router>
    );
}

export default App;
