import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const DashboardPage = () => {
    const [role, setRole] = useState('');
    const navigate = useNavigate();

    useEffect(() => {
        const fetchRole = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/current-user', {
                        withCredentials: true,
                        maxRedirects: 0,
                });
                setRole(response.data.role);
                console.log('User role fetched:', response.data.role);
                if(!response.data.role) navigate('/');
            } catch (error) {
                console.error('Login failed:', error);
            }
        };

        fetchRole();
    }, []);

    const logout = async () => {
        try {
            await axios.post('http://localhost:8080/logout', {}, {
                withCredentials: true,
                maxRedirects: 0,
            });
            navigate('/');
        } catch (error) {
            console.error('Logout failed:', error);
        }
    };

    return (
        <div>
            <h1>Dashboard</h1>
            <nav>
                {role === 'ADMIN' && (
                    <ul>
                        <li><Link to="/persons">Persons</Link></li>
                        <li><Link to="/items">Items</Link></li>
                    </ul>
                )}
                {role === 'KULLANICI' &&
                    <ul>
                        <li><Link to="/persons">Persons</Link></li>
                    </ul>
                }
            </nav>
            <div>
                <button onClick={logout}>Çıkış</button>
            </div>
        </div>
    );
};

export default DashboardPage;
