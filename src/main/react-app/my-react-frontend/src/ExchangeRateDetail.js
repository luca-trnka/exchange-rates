import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import { displayValue } from './formatUtils'

const ExchangeRateDetail = () => {
    const { shortName } = useParams();
    const [rateDetail, setRateDetail] = useState(null);
    const navigate = useNavigate();


    useEffect(() => {
        fetch(`http://localhost:8080/api/exchange-rates/detail/${shortName}`)
            .then(response => response.json())
            .then(data => {
                setRateDetail(data);
            })
            .catch(error => console.error('Chyba při získávání detailu:', error));
    }, [shortName]);

    if (!rateDetail) return <div>Načítání...</div>;

    return (
        <div className="container">
            <h1>Detail měny: {rateDetail.shortName}</h1>
            <table>
                <thead>
                <tr>
                    <th>Název</th>
                    <th>Země</th>
                    <th>Nákupní Hodnota</th>
                    <th>Prodejní Hodnota</th>
                    <th>Střední Hodnota</th>
                    <th>Nákupní Kurz</th>
                    <th>Prodejní Kurz</th>
                    <th>Střední Kurz</th>
                    <th>Množství</th>
                    <th>Pohyb</th>
                    <th>Verze</th>
                    <th>Střední Kurz ČNB</th>
                    <th>Střední Kurz ECB</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>{rateDetail.name}</td>
                    <td>{rateDetail.country}</td>
                    <td>{displayValue(rateDetail.valBuy)}</td>
                    <td>{displayValue(rateDetail.valSell)}</td>
                    <td>{displayValue(rateDetail.valMid)}</td>
                    <td>{displayValue(rateDetail.currBuy)}</td>
                    <td>{displayValue(rateDetail.currSell)}</td>
                    <td>{displayValue(rateDetail.currMid)}</td>
                    <td>{displayValue(rateDetail.amount)}</td>
                    <td>{displayValue(rateDetail.move)}</td>
                    <td>{displayValue(rateDetail.version)}</td>
                    <td>{displayValue(rateDetail.cnbMid)}</td>
                    <td>{displayValue(rateDetail.ecbMid)}</td>
                </tr>
                </tbody>
            </table>
            <button onClick={() => navigate(-1)} className="button-back">Zpět na seznam</button>
        </div>
    );
};

export default ExchangeRateDetail;
