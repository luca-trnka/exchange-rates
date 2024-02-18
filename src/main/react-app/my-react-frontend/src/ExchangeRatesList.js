import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { displayValue } from './formatUtils'

const ExchangeRatesList = () => {
    const [rates, setRates] = useState([]);

    // verze pro extrakci dat z externího API:
    // useEffect(() => {
    //     fetch('https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e')
    //         .then(response => response.json())
    //         .then(data => setRates(data))
    //         .catch(error => console.error('Chyba při získávání dat:', error));
    // }, []);

    useEffect(() => {
        fetch('http://localhost:8080/api/exchange-rates?usedb=false')
            .then(response => response.json())
            .then(data => {
                const sortedData = data.sort((a, b) => a.shortName.localeCompare(b.shortName)); //seřadí měny podle abecedy
                setRates(sortedData);
            })
            .catch(error => console.error('Chyba při získávání dat:', error));
    }, []);

    return (
        <div className="container">
            <h1>Kurzovní lístek</h1>
            <table className="table-list">
                <thead>
                <tr>
                    <th>Zkratka</th>
                    <th>Měna</th>
                    <th>Země</th>
                    <th>Množství</th>
                    <th>Nakupujeme</th>
                    <th>Prodáváme</th>
                    <th>ČNB střed</th>
                </tr>
                </thead>
                <tbody>
                {rates.map(rate => (
                    <tr key={rate.shortName}>
                        <td className="link-cell"><Link to={`/detail/${rate.shortName}`}>{rate.shortName}</Link></td>
                        <td>{rate.name}</td>
                        <td>{rate.country}</td>
                        <td>{rate.amount}</td>
                        <td>{displayValue(rate.currBuy)}</td>
                        <td>{displayValue(rate.currSell)}</td>
                        <td>{displayValue(rate.cnbMid)}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default ExchangeRatesList;
