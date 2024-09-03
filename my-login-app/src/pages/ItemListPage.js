import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {useNavigate} from "react-router-dom";

const ItemListPage = () => {
    const [items, setItems] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        axios.get('http://localhost:8080/api/item/getItems',{
            withCredentials: true,
            maxRedirects: 0,
        })
            .then(response => setItems(response.data))
            .catch(error => console.error('Login failed:', error));
    }, []);

    return (
        <div>
            <h1>Items</h1>
            <ul>
                {items.map(item => (
                    <li key={item.id}>{item.itemName}</li>
                ))}
            </ul>
        </div>
    );
};

export default ItemListPage;
