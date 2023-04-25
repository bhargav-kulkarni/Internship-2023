import { render, screen } from '@testing-library/react';
import App from './App';
import AddContact from './compoents/AddContact';

test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});

it('render the Addcontact compoent', () => {
  render(< AddContact />)
  const name = screen.getAllByPlaceholderText("Name")
  expect(name).toBeInTheDocument();


})
