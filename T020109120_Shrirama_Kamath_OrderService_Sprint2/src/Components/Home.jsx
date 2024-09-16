import React,{useState, useEffect} from 'react';
import OrderService from '../Services/OrderService.js';
function Home()
{
    const [orders,setPro]=useState([]);

    useEffect(()=>{
        getAllOrdersHere()
    },[])

    const getAllOrdersHere=()=>{
        OrderService.getAllOrders()
        .then((res)=>{
            console.log(res.data)
            setPro(res.data)
        })
        .catch(err=>{
            console.log(err)
        })
    }
    return(
        <main>
                <h1>Order Details</h1>
                <table cellPadding={10} cellSpacing={5} border={2}>
                    <tr>
                        <td>ID</td>
                        <td>Customer ID</td>
                        <td>Store ID</td>
                        <td>Order Date</td>
                        <td>Total Price</td>
                        <td>Mode of Payment</td>
                    </tr>
                {
                    orders.map(post=>(
                        <tr>
                            <td>{post.id}</td>
                            <td>{post.customerId}</td>
                            <td>{post.shopId}</td>
                            <td>{post.dateOfPurchase}</td>
                            <td>{post.total}</td>
                            <td>{post.paymentMode}</td>
                        </tr>
                           
                ))
                }      
                </table>       
        </main>
    );
}
export default Home;