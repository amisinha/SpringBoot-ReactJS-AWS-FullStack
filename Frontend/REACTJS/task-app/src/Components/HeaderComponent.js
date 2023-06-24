import React from 'react'
import '../HeaderComponent.css'

const HeaderComponent = () => {
  return (
    <div>
        <header>
            <nav className='navbar navbar-expand-md navbar-dark bg-dark'>
                <div>
                <a href = "https://google.com" className = "navbar-brand" >
                        Tasks Management Application
                </a>
                </div>

            </nav>
        </header>
    </div>
  )
}

export default HeaderComponent