import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const PersonListPage = () => {
    const [persons, setPersons] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        axios.get('http://localhost:8080/api/person/getPersons',{
            withCredentials: true,
            maxRedirects: 0,
        })
            .then(response => setPersons(response.data))
            .catch(error => console.error('Login failed:', error));
    }, []);

    return (
        <div>
            <h1>Persons</h1>
            <ul>
                {persons.map(person => (
                    <li key={person.id}>{person.name}</li>
                ))}
            </ul>
        </div>
    );
};

export default PersonListPage;
