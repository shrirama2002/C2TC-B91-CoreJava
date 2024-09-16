import React,{useState, useEffect} from 'react';
import OrderService from '../Services/OrderService';
import {Link} from 'react-router-dom'

function Order()
{
    const [orders,setPost]=useState([]);
    const [id,setid]=useState("");

    function del(id,e)
    {
        OrderService.deleteOrders(id)
            .then(res =>{
                alert("Order with ID: "+id+" Successfully deleted");
                window.location.reload(true);
              
            })
            .catch(err=>{
                console.log(err)
            })
    }

    useEffect(()=>{
        OrderService.getAllOrders()
            .then(res =>{
                setPost(res.data)
            })
            .catch(err=>{
                console.log(err)
            })
    },[])
    return(
        <div>
            <div id="na">
                <form onSubmit={del(id)}>
                    <Link to="/add" className='add btn'>ADD</Link>
                    OR Select to remove
                    <select name="id" value={id} onChange={(e)=>setid(e.target.value)}>
                        <option>Select order id</option>
                        {
                        orders.map(post=>(
                        <option value={post.id}>{post.id}</option>    
                        ))
                        }
                    </select>
                </form>
            </div>
            <main>
            <h1>Order Details</h1>
                <table cellPadding={10} cellSpacing={5} border={2}>
                    <tr>
                        <td>ID</td>
                        <td>Customer ID</td>
                        <td>Shop ID</td>
                        <td>Order Date</td>
                        <td>Total Price</td>
                        <td>Mode of Payment</td>
                        <td>Action</td>
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
                            <td><Link to={"/upd/"+post.id} className='upd btn'>Update</Link></td>
                        </tr>
                           
                ))
                }      
                </table> 
            </main>
        </div>
    );
}
export default Order;