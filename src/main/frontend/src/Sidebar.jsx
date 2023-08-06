import * as React from 'react';
import { styled, useTheme } from '@mui/material/styles';
import Box from '@mui/material/Box';
import Drawer from '@mui/material/Drawer';
import CssBaseline from '@mui/material/CssBaseline';
import MuiAppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import ChevronLeftIcon from '@mui/icons-material/ChevronLeft';
import ChevronRightIcon from '@mui/icons-material/ChevronRight';
import { Link, useLocation } from "react-router-dom";


const drawerWidth = 240;

const Main = styled('main', { shouldForwardProp: (prop) => prop !== 'open' })(
  ({ theme, open }) => ({
    flexGrow: 1,
    padding: theme.spacing(3),
    transition: theme.transitions.create('margin', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
    marginLeft: `-${drawerWidth}px`,
    ...(open && {
      transition: theme.transitions.create('margin', {
        easing: theme.transitions.easing.easeOut,
        duration: theme.transitions.duration.enteringScreen,
      }),
      marginLeft: 0,
    }),
  }),
);

const AppBar = styled(MuiAppBar, {
  shouldForwardProp: (prop) => prop !== 'open',
})(({ theme, open }) => ({
  transition: theme.transitions.create(['margin', 'width'], {
    easing: theme.transitions.easing.sharp,
    duration: theme.transitions.duration.leavingScreen,
  }),
  ...(open && {
    width: `calc(100% - ${drawerWidth}px)`,
    marginLeft: `${drawerWidth}px`,
    transition: theme.transitions.create(['margin', 'width'], {
      easing: theme.transitions.easing.easeOut,
      duration: theme.transitions.duration.enteringScreen,
    }),
  }),
}));

const DrawerHeader = styled('div')(({ theme }) => ({
  display: 'flex',
  alignItems: 'center',
  padding: theme.spacing(0, 1),
  // necessary for content to be below app bar
  ...theme.mixins.toolbar,
  justifyContent: 'flex-end',
}));

export default function PersistentDrawerLeft() {
  const theme = useTheme();
  const [open, setOpen] = React.useState(false);

  const handleDrawerOpen = () => {
    setOpen(true);
  };

  const handleDrawerClose = () => {
    setOpen(false);
  };

  const location = useLocation();

  return (
    <Box sx={{ display: 'flex' }}>

      <CssBaseline />

      <AppBar position="fixed" open={open} sx={{backgroundColor: "#D0E289", color: "black"}}>

        <Toolbar>
          <IconButton
            color="inherit"
            aria-label="open drawer"
            onClick={handleDrawerOpen}
            edge="start"
            sx={{ mr: 2, ...(open && { display: 'none' }) }}
          >
            <MenuIcon />
          </IconButton>

          <Typography variant="h4" noWrap component="div">
            화장지
          </Typography>

        </Toolbar>

      </AppBar>


      <Drawer
        sx={{
          width: drawerWidth,
          flexShrink: 0,
          '& .MuiDrawer-paper': {
            width: drawerWidth,
            boxSizing: 'border-box',
          },
        }}
        variant="persistent"
        anchor="left"
        open={open}
      >
        <DrawerHeader>
          <IconButton onClick={handleDrawerClose}>
            {theme.direction === 'ltr' ? <ChevronLeftIcon /> : <ChevronRightIcon />}
          </IconButton>
        </DrawerHeader>
        
        <div className = "sidemenu">
          <Link
          to="/addRestroom" state={{ background: location }}
          style={{ textDecoration: 'none', color: 'black', fontSize: 20 }}
          >
            신규 정보 등록
          </Link>
        </div>



        <div className = "sidemenu">
          <Link
          to="/requestEditing" state={{ background: location }}
          style={{ textDecoration: 'none', color: 'black', fontSize: 20 }}
          >
            정보 수정 요청
          </Link>
        </div>




        <div className = "sidemenu">
          <Link
          to="/myReview" state={{ background: location }}
          style={{ textDecoration: 'none', color: 'black', fontSize: 20 }}
          >
            내가 쓴 리뷰
          </Link>
        </div>




        <div className = "sidemenu">
          <Link to="/myAccount" state={{ background: location }}
          style={{ textDecoration: 'none', color: 'black', fontSize: 20 }}
          >
            계정 관리
          </Link>
        </div>




        <div className = "sidemenu">
          <Link
          to="/reviews" state={{ background: location }}
          style={{ textDecoration: 'none', color: 'black', fontSize: 20}}
          >
            리뷰 등록
          </Link>
        </div>
        
      </Drawer>

      <Main open={open}>
        <DrawerHeader />
      </Main>
      
    </Box>
  );
}