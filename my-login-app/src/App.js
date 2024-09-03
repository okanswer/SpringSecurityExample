import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import DashboardPage from './pages/DashboardPage';
import PersonListPage from './pages/PersonListPage';
import ItemListPage from './pages/ItemListPage';
import ErrorPage from './pages/ErrorPage';

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<LoginPage />} />
                <Route path="/dashboard" element={<DashboardPage />} />
                <Route path="/persons" element={<PersonListPage />} />
                <Route path="/items" element={<ItemListPage />} />
                <Route path="/404" element={< ErrorPage />} />
            </Routes>
        </Router>
    );
}

export default App;
