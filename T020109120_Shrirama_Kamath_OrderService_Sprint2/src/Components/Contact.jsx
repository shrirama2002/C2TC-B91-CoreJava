import './Contact.css';


function Contact()
{
    
    return(
        <div class="fun" style={{fontSize: +30}}>
            <div class="container main">
                <h1>Fill this Form</h1>
                <p style={{textAlign:'center'}}>Happy to help you contact us here</p>
                <div class="contact-form">
                    <form>
                        <input type="text" name="name" placeholder="Your Name" required />
                        <input type="email" name="email" placeholder="Your Email" required/>
                        <textarea name="message" rows="5" placeholder="Your Message" required ></textarea>
                        <button className='btn add' style={{width: '180px'}} type='submit'>Send Message</button>
                    </form>
                </div>
            </div>
        </div>
    );
}
export default Contact;