import React, { Component } from 'react';

class HeaderCmp extends Component {
    constructor(props) {
        super(props)
        this.state = {}
    }
    render() {
        return (
            <div>
                <header>
                    
                    <nav className='navbar navbar-expand-lg navbar-dark bg-dark'>
                        <div className="navbar-brand">Job Board Service</div>
                        <div className="container-fluid">

                            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                <span className="navbar-toggler-icon"></span>
                            </button>

                            <div className="collapse navbar-collapse" id="navbarSupportedContent">
                                <ul className="navbar-nav mr-auto"></ul>
                                <ul className="navbar-nav">
                                    <li className="nav-item active">
                                        <a className="nav-link" >home</a>
                                    </li>
                                    <li className="nav-item active">
                                        <a className="nav-link" >login</a>
                                    </li>
                                    <li className="nav-item active">
                                        <a className="nav-link" >logout</a>

                                    </li>
                                    <li className="nav-item active">
                                        <a className="nav-link" >Users</a>
                                    </li>



                                </ul>

                            </div>
                        </div>

                    </nav>
                </header>

            </div>
        );
    }
}

export default HeaderCmp;