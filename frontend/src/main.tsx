import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'

import '@fontsource/roboto/300.css';
import '@fontsource/roboto/400.css';
import '@fontsource/roboto/500.css';
import '@fontsource/roboto/700.css';
import { CssBaseline, ThemeProvider, createTheme } from '@mui/material';
import { RouterProvider } from 'react-router-dom';
import { router } from './Routing.tsx';
import { Colors } from './constants/Colors.ts';
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';

const theme = createTheme({
  palette: {
    background: Colors.background,
    primary: Colors.primary,
  }
})

const queryClient = new QueryClient()

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <QueryClientProvider client={queryClient}>
        <RouterProvider router={router} />
      </QueryClientProvider>
    </ThemeProvider>
  </React.StrictMode>,
)
