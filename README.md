# Aplikace: Kurzovní Lístky 

Tato aplikace slouží k zobrazení kurzovních lístků. Umožňuje uživatelům získat aktuální kurzy měn jak z České spořitelny prostřednictvím jejich veřejného API, tak i z lokální databáze.

## Hlavní Funkce

- Získání a zobrazení seznamu aktuálních kurzů měn.
- Možnost zobrazit detail každé měny.

## Technologie

- **Frontend:** React
- **Backend:** Spring Boot
- **Databáze:** H2 Database (pro účely demonstrace, snadno nahraditelná např. MySQL)
- **Správa projektu:** Gradle

## Jak Spustit Aplikaci

### Požadavky

- Java JDK 11 nebo vyšší
- Node.js a npm
- Git

### Klonování Repozitáře

git clone https://github.com/luca-trnka/exchange-rates.git
cd kurzovni-listky

Spuštění Backendu
Přejděte do složky backendu:
cd backend

Sestavte a spusťte aplikaci pomocí Gradle:
./gradlew bootRun
Aplikace běží na portu 8080.

Spuštění Frontendu
Otevřete nový terminál a přejděte do složky frontendu:
cd frontend

Nainstalujte závislosti a spusťte React aplikaci:
npm install
npm start
Frontend běží na portu 3000 a je přístupný v prohlížeči na adrese http://localhost:3000.

API
Získání seznamu kurzovních lístků: GET http://localhost:8080/api/exchange-rates?usedb=true/false
Získání detailu měny: GET http://localhost:8080/api/exchange-rates/detail/{shortName}
