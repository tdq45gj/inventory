import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class ItemList extends Component {

    constructor(props) {
        super(props);
        this.state = {items: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/api/item/')
            .then(response => response.json())
            .then(
                (data) => {
                    console.log(data)
                    this.setState({items: data})
                },
                (error) => {
                    console.log(error)
                }
            );
    }

    async remove(id) {
        await fetch(`/api/item/delete/${id}`, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedItems = [...this.state.items].filter(i => i.id !== id);
            this.setState({items: updatedItems});
        });
    }

    async export() {
        fetch(`/api/item/export`)
            .then((res) => {
                return res.blob();
            })
            .then((blob) => {
                const href = window.URL.createObjectURL(blob);
                const link = document.createElement('a');
                link.href = href;
                link.setAttribute('download', 'items.csv');
                document.body.appendChild(link);
                link.click();
                document.body.removeChild(link);
            })
    }


    render() {
        const {items} = this.state;

        const itemList = items.map(item => {
            return <tr key={item.id}>
                <td style={{whiteSpace: 'nowrap'}}>{item.id}</td>
                <td>{item.name}</td>
                <td>{item.description}</td>
                <td>{item.price}</td>
                <td>{item.count}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/item/" + item.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(item.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/item/new">Add Item</Button>
                    </div>
                    <div className="float-right">
                        <Button color="info" onClick={() => this.export()}>Export CSV</Button>
                    </div>
                    <h3>Items</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="10%">Id</th>
                            <th width="20%">Name</th>
                            <th width="30%">Description</th>
                            <th width="20%">Price</th>
                            <th width="20%">Count</th>
                            <th width="20%">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {itemList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default ItemList;