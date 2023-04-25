import React from "react";
import { fireEvent, render, screen } from '@testing-library/react';
import '@testing-library/jest-dom';
import LogViewer from "../Compoents/LogViewer";

it("render LogViewer Compoent", () => {
    render(<LogViewer />)
    const placeholder = screen.getByPlaceholderText("Enter container ID");
    const submitButton = screen.getByText(/Submit/i)
    const printButton = screen.getByText(/print/i)
    const heading = screen.getByText(/Docker Error logs/i);
    const textArea = screen.getByTitle("textArea1");
    expect(placeholder).toBeInTheDocument();
    expect(submitButton).toBeInTheDocument();
    expect(printButton).toBeInTheDocument();
    expect(heading).toBeInTheDocument();
    expect(textArea).toBeInTheDocument();
});


it("to test button onClick processs.", () => {
    render(<LogViewer />)

    const placeholder = screen.getByPlaceholderText("Enter container ID");
    fireEvent.change(placeholder, { target: { value: '4df2df7971cc2b47f538c7498c603a9109d7bcc7500641feffc7a629e3eb12fd' } })
    expect(placeholder.value).toBe("4df2df7971cc2b47f538c7498c603a9109d7bcc7500641feffc7a629e3eb12fd");
    const submitButton = screen.getByText(/Submit/i)
    fireEvent.click(submitButton);
    const textArea = screen.getByTitle("textArea1");
    expect(textArea.value).toBe('');


});