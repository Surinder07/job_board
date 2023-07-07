import React, { Component } from 'react';

class FooterCmp extends Component {
    constructor(props){
        super(props)
        this.state ={}
    }
    render() {
        return (
            <div>
                <footer className='footer'>
                    <span className='text-muted'>All rights Reserved 2023 @AmritRekha</span>
                </footer>
            </div>
        );
    }
}

export default FooterCmp;