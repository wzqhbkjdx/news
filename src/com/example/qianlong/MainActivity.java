package com.example.qianlong;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity 
{
	private MenuFragment mMenuFragment;
	private HomeFragment2 mHomeFragment;
	@Override
	
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setBehindContentView(R.layout.menu_frame);
		setContentView(R.layout.content_frame);
		
		SlidingMenu sm = getSlidingMenu();
		sm.setMode(SlidingMenu.LEFT);
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
		
		if(savedInstanceState==null)
		{
			mMenuFragment = new MenuFragment();
			mHomeFragment =new HomeFragment2();
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.menu_frame, mMenuFragment,"Menu").commit();
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.content_frame,mHomeFragment ,"Home").commit();
			
		}
		
	}


	public MenuFragment getMenuFragment(){
		mMenuFragment = (MenuFragment) getSupportFragmentManager().findFragmentByTag("Menu");
		return mMenuFragment;
		
	}
}
